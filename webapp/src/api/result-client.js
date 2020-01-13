import axios from "axios";

/**
 * Fetches all results from the backend service
 * @returns {Promise<AxiosResponse<T>>}
 */
export async function fetchResults() {
    return await axios.get("/result").then(response => {return response.data});
}