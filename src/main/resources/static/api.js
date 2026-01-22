import axios from "axios";

export const BASE_URL = "http://localhost:8080/api/jobs";

export const addJob = (job) => axios.post(BASE_URL, job);
export const getJobs = () => axios.get(BASE_URL);
export const scheduleJobs = () => axios.get(`${BASE_URL}/schedule`);
