import React from "react";
import {Nav} from "react-bootstrap";
import PropTypes from "prop-types";
import TabNavigationItem from "./TabNavigationItem";

const TabNavigation = props => {

    return (
        <Nav variant="pills" className="parties-navbar">
            {props.parties.map(party => {
                return (<TabNavigationItem key={party.id} party={party}/>);
            })}
        </Nav>
    );
};

TabNavigation.propTypes = {
    parties: PropTypes.array.isRequired
};

export default TabNavigation;