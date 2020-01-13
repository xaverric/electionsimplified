import React from "react";
import {Nav, Tab} from "react-bootstrap";
import PropTypes from "prop-types";
import CandidateList from "../../../candidate/list/CandidateList";

const TabContentItem = props => {

    return (
        <Tab.Pane eventKey={props.party.id}>
            <CandidateList partyId={props.party.id}/>
        </Tab.Pane>
    );
};

TabContentItem.propTypes = {
    party: PropTypes.object.isRequired
};

export default TabContentItem;