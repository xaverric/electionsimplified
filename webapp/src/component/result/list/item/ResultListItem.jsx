import React from "react";
import PropTypes from "prop-types";

const ResultListItem = props => {

    return (
        <tr>
            <td>{props.result.partyName}</td>
            <td>{props.result.candidateName}</td>
            <td><strong>Votes:</strong> {props.result.votes}</td>
        </tr>
    );
};

ResultListItem.propTypes = {
    result: PropTypes.shape({
        partyName: PropTypes.string.isRequired,
        candidateName: PropTypes.string.isRequired,
        candidateColor: PropTypes.string.isRequired,
        votes: PropTypes.string.isRequired,
        filtered: PropTypes.bool
    }).isRequired
};

export default ResultListItem;