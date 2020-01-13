import React, {useEffect, useState} from "react";
import PieChart from "react-minimal-pie-chart";
import resultsSort from "../../../util/array-sort";

const ResultGraph = props => {

    const [results, setResults] = useState([]);

    useEffect(() => {
        setResults(transformDataForPieChart(props.data));
    }, [props.data]);

    const transformDataForPieChart = data => {
        let pieChartData = [];
        data.filter(item => item.filtered === true).forEach(item => {
            pieChartData.push(getPieChartItem(item));
        });
        return pieChartData;
    };

    const getPieChartItem = resultItem => {
        return {
            title: resultItem.candidateName,
            value: resultItem.votes,
            color: resultItem.candidateColor
        }
    };

    return (
        <PieChart data={resultsSort(results, "DESC")} />
    )
};

export default ResultGraph;