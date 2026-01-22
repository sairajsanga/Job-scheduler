const ScheduleResult = ({ result }) => (
    <div>
        <h2>Total Profit: {result.totalProfit}</h2>
        <ul>
            {result.scheduledJobs?.map(j => (
                <li key={j.id}>{j.jobName} → Slot {j.slot}</li>
            ))}
        </ul>
    </div>
);

export default ScheduleResult;
