import axios from "axios";

/**
 * Fetches all candidates for giver party from the backend service
 * @returns {Promise<AxiosResponse<T>>}
 */
export async function fetchCandidates(partyId) {
    return await axios.get("/candidate?partyId=" + partyId ).then(response => {return response.data});
}