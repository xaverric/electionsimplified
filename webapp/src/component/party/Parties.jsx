import React, {useState, useEffect} from "react";
import {Col, Row, Tabs, Tab, Nav} from "react-bootstrap";
import "./Parties.css"
import TabNavigation from "./tab/navigation/TabNavigation";
import TabContent from "./tab/content/TabContent";
import {fetchParties} from "../../api/party-client";

const Parties = () => {

    const [parties, setParties] = useState([]);

    useEffect(() => {
        fetchParties().then(data => setParties(data));
    }, []);

    return (
        <Tab.Container>
            <TabNavigation parties={parties} />
            <TabContent parties={parties}/>
        </Tab.Container>
    );
};

export default Parties;