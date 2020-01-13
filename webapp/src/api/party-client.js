import axios from "axios";

/**
 * Fetches all parties from the backend service
 * @returns {Promise<AxiosResponse<T>>}
 */
export async function fetchParties() {
    return await axios.get("/party").then(response => {return response.data});
}