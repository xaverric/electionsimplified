export function filter(array, partyFilter, candidateFilter) {
    return array.map(result => {
        if (filterMatches(result, partyFilter, candidateFilter)) {
            return {...result, filtered: true}
        } else {
            return {...result, filtered: false}
        }
    });
}

function filterMatches(result, partyFilter, candidateFilter) {
    return valueFilterCheck(result.partyName, partyFilter) && valueFilterCheck(result.candidateName, candidateFilter)
}

function valueFilterCheck(value, filter){
    return value.toLowerCase().includes(filter.toLowerCase());
}