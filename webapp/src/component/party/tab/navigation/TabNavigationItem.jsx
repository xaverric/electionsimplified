import React from "react";
import {Nav} from "react-bootstrap";
import PropTypes from "prop-types";

const TabNavigationItem = props => {

    return (
        <Nav.Item className="parties-navbar-item">
            <Nav.Link eventKey={props.party.id}>{props.party.partyName}</Nav.Link>
        </Nav.Item>
    );
};

TabNavigationItem.propTypes = {
    party: PropTypes.shape({
        id: PropTypes.number.isRequired,
        partyName: PropTypes.string.isRequired,
        candidates: PropTypes.array
    }).isRequired
};

export default TabNavigationItem;