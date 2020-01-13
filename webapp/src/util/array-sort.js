const asc = "ASC";
const desc = "DESC";

function sortResultAsc(a, b) {
    return a.votes - b.votes;
}

function sortResultsDesc(a, b) {
    return b.votes - a.votes;
}

function sortResult(a, b, order){
    if (order === asc) {
        return sortResultAsc(a, b);
    } else if (order === desc){
        return sortResultsDesc(a, b);
    }
}

export default function resultsSort(array, order){
    let result = [...array];
    return result.sort((a, b) => {
        return sortResult(a, b, order);
    });
}

