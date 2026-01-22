import { useState } from "react";
import { addJob } from "../api";

const JobForm = ({ refresh }) => {
    const [jobName, setJobName] = useState("");
    const [deadline, setDeadline] = useState("");
    const [profit, setProfit] = useState("");

    const submit = async () => {
        await addJob({ jobName, deadline, profit });
        setJobName(""); setDeadline(""); setProfit("");
        refresh();
    };

    return (
        <div>
            <input placeholder="Job Name" onChange={e => setJobName(e.target.value)} />
            <input placeholder="Deadline" type="number" onChange={e => setDeadline(e.target.value)} />
            <input placeholder="Profit" type="number" onChange={e => setProfit(e.target.value)} />
            <button onClick={submit}>Add Job</button>
        </div>
    );
};

export default JobForm;
