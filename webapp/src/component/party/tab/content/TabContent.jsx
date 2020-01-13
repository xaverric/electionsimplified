import React from "react";
import {Tab} from "react-bootstrap";
import PropTypes from "prop-types";
import TabContentItem from "./TabContentItem";
const TabContent = props => {

    return (
        <Tab.Content>
            {props.parties.map(party => {
                return (<TabContentItem key={party.id} party={party}/>);
            })}
        </Tab.Content>
    );
};

TabContent.propTypes = {
    parties: PropTypes.array.isRequired
};

export default TabContent;