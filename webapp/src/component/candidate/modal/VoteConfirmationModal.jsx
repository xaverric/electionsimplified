import React from "react";
import {Button, Modal} from "react-bootstrap";
import PropTypes from "prop-types";

const VoteConfirmationModal = props => {

    const submit = () => {
        props.handleVote(props.candidate.uuid);
    };

    const cancel = () => {
        props.handleHide();
    };

    return (
        <Modal onHide={props.handleHide} show={props.shown} size="lg" centered>
            <Modal.Header closeButton>
                <Modal.Title>
                    Confirmation
                </Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <h4>Vote for {props.candidate.name}</h4>
                <p>
                    You are going to vote for candidate {props.candidate.name}. Do you confirm your vote?
                </p>
            </Modal.Body>
            <Modal.Footer>
                <Button onClick={submit}>Confirm</Button>
                <Button variant="danger" onClick={cancel}>Cancel</Button>
            </Modal.Footer>
        </Modal>
    );
};

VoteConfirmationModal.propTypes = {
    shown: PropTypes.bool.isRequired,
    candidate: PropTypes.object.isRequired,
    handleHide: PropTypes.func.isRequired,
    handleVote: PropTypes.func.isRequired,
};

export default VoteConfirmationModal;