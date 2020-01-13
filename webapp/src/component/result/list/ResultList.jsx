import React, {useEffect, useState} from "react";
import {Table} from "react-bootstrap";
import ResultListItem from "./item/ResultListItem";
import resultsSort from "../../../util/array-sort";
import "./ResultList.css";
import {filter} from "../../../util/array-filter";
import ResultListFilter from "./filter/ResultListFilter";


const ResultList = props => {

    const [results, setResults] = useState([]);
    const [partyFilterValue, setPartyFilterValue] = useState("");
    const [candidateFilterValue, setCandidateFilterValue] = useState("");

    useEffect(() => {
        props.handleFilterData(filter(results, partyFilterValue, candidateFilterValue));
    }, [partyFilterValue, candidateFilterValue]);

    useEffect(() => {
        setResults(resultsSort(props.data, "DESC"));
    }, [props.data]);

    return (
        <>
            <Table bordered>
                <thead>
                <ResultListFilter
                    setPartyFilterValueCallback={setPartyFilterValue}
                    setCandidateFilterValueCallback={setCandidateFilterValue}
                    setResultsCallback={setResults}
                    results={results}/>
                </thead>
                <tbody>
                {results.map(result => result.filtered && <ResultListItem result={result}/>)}
                </tbody>
            </Table>
        </>

    );
};

export default ResultList;