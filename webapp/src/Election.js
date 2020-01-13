import React from 'react';
import {Navbar, Nav} from "react-bootstrap";
import {BrowserRouter as Router, Route, Switch} from "react-router-dom";
import CandidateView from "./view/candidates/CandidateView";
import "./Election.css";
import ResultView from "./view/results/ResultView";
import LandingPageView from "./view/landingpage/LandingPageView";

const Election = () => {

    return (
        <>
            <Navbar bg="light" variant="light">
                <Navbar.Brand href="/">Election</Navbar.Brand>
                <Nav className="mr-auto">
                    <Nav.Link href="/candidates">Candidates</Nav.Link>
                    <Nav.Link href="/results">Results</Nav.Link>
                </Nav>
            </Navbar>

            <div className="bodyWrapper">
                <Router>
                    <Switch>
                        <Route exact path="/" component={() => <LandingPageView />}/>
                        <Route exact path="/candidates" component={() => <CandidateView />}/>
                        <Route exact path="/results" component={() => <ResultView />}/>
                    </Switch>
                </Router>
            </div>
        </>
    );
};

export default Election;
