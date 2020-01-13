import React from "react";
import {Button, ButtonGroup, Form} from "react-bootstrap";
import resultsSort from "../../../../util/array-sort";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faAngleDown, faAngleUp} from "@fortawesome/free-solid-svg-icons";
import PropTypes from "prop-types";

const ResultListFilter = props => {

    return (
        <tr>
            <th>
                <Form>
                    <Form.Control placeholder="Party" onChange={e => props.setPartyFilterValueCallback(e.target.value)}/>
                </Form>
            </th>
            <th>
                <Form>
                    <Form.Control placeholder="Candidate" onChange={e => props.setCandidateFilterValueCallback(e.target.value)}/>
                </Form>
            </th>
            <th>
                <ButtonGroup size="sm" className="sortButtonGroup">
                    <Button onClick={() => props.setResultsCallback(resultsSort(props.results, "ASC"))}><FontAwesomeIcon icon={faAngleUp}/></Button>
                    <Button onClick={() => props.setResultsCallback(resultsSort(props.results, "DESC"))}><FontAwesomeIcon icon={faAngleDown}/></Button>
                </ButtonGroup>

            </th>
        </tr>
    );
};

ResultListFilter.propTypes = {
    setPartyFilterValueCallback: PropTypes.func.isRequired,
    setCandidateFilterValueCallback: PropTypes.func.isRequired,
    setResultsCallback: PropTypes.func.isRequired,
    results: PropTypes.array.isRequired,
};

export default ResultListFilter;
