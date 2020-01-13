import React from "react"
import {Button, Jumbotron, Navbar} from "react-bootstrap";

const LandingPageView = () => {

    return (
        <>
            <Jumbotron>
                <h1>Welcome to Election Simplified</h1>
                <p>
                    Election has never been this easy. Just go to the candidate page, get information about all the candidates and then choose one. After confirmation, visit the current elections result.
                </p>
                <p>
                    <Button variant="primary" href="/candidates">Candidates</Button>
                </p>
            </Jumbotron>
            <Navbar bg="light" fixed="bottom" bsPrefix="footer">
                <small>Copyright &copy; Daniel Jílek</small>
            </Navbar>
        </>
    );
};

export default LandingPageView;