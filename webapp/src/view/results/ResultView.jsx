import React, {useEffect, useState} from "react"
import ResultList from "../../component/result/list/ResultList";
import ResultGraph from "../../component/result/graph/ResultGraph";
import "./ResultsView.css"
import {fetchResults} from "../../api/result-client";

const ResultView = () => {

    const [results, setResults] = useState([]);

    useEffect(() => {
        fetchResults().then(data => setResults(data));
    }, []);

    const handleFilterData = (filteredData) => {
        setResults(filteredData);
    };

    return (
        <>
            <h2>Results</h2>
            <div className={"list"}>
                <ResultList data={results} handleFilterData={handleFilterData}/>
            </div>
            <div className={"graph-box"}>
                <ResultGraph data={results}/>
            </div>
        </>
    );
};

export default ResultView;