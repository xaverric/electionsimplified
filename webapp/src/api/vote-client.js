import axios from "axios";

/**
 * Fetches all parties from the backend service
 * @returns {Promise<AxiosResponse<T>>}
 */
export async function saveVote(dtoIn) {
    return await axios.post("/vote", dtoIn).then(response => {return response.data});
}