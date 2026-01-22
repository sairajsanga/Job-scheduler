import { useEffect, useState } from "react";
import { getJobs, scheduleJobs } from "./api";
import JobForm from "./components/JobForm";
import JobList from "./components/JobList";
import ScheduleResult from "./components/ScheduleResult";

function App() {
    const [jobs, setJobs] = useState([]);
    const [result, setResult] = useState({});

    const loadJobs = async () => {
        const res = await getJobs();
        setJobs(res.data);
    };

    const runScheduler = async () => {
        const res = await scheduleJobs();
        setResult(res.data);
    };

    useEffect(() => {
        loadJobs();
    }, []);

    return (
        <div>
            <h1>Job Scheduling System</h1>
            <JobForm refresh={loadJobs} />
            <JobList jobs={jobs} />
            <button onClick={runScheduler}>Run Scheduler</button>
            <ScheduleResult result={result} />
        </div>
    );
}

export default App;
