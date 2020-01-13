import React from "react";
import {Card, Button} from "react-bootstrap";
import "./Candidate.css";
import PropTypes from "prop-types";

const Candidate = props => {

    return (
      <>
          <Card bsPrefix="candidateCard">
              <Card.Body bsPrefix="candidateCardBorder">
                  <Card.Title>{props.candidate.name}</Card.Title>
                  <Card.Text>
                      Some quick example text to build on the card title and make up the bulk of
                      the card's content.
                  </Card.Text>
                  <Button variant="primary" onClick={() => props.openVoteModalCallback(props.candidate)}>Vote</Button>
              </Card.Body>
          </Card>
      </>
    );
};

Candidate.propTypes = {
    candidate: PropTypes.object.isRequired,
    openVoteModalCallback: PropTypes.func.isRequired
};

export default Candidate;