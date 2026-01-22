const JobList = ({ jobs }) => (
    <table>
        <thead>
        <tr>
            <th>Job</th><th>Deadline</th><th>Profit</th>
        </tr>
        </thead>
        <tbody>
        {jobs.map(j => (
            <tr key={j.id}>
                <td>{j.jobName}</td>
                <td>{j.deadline}</td>
                <td>{j.profit}</td>
            </tr>
        ))}
        </tbody>
    </table>
);

export default JobList;
