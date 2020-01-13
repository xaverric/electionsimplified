import React, {useState, useEffect} from "react";
import "./CandidateList.css";
import Candidate from "./item/Candidate";
import VoteConfirmationModal from "../modal/VoteConfirmationModal";
import PropTypes from "prop-types";
import {fetchCandidates} from "../../../api/candidates-client";
import {saveVote} from "../../../api/vote-client";

const CandidateList = props => {

    const [candidates, setCandidates] = useState([]);
    const [modalShown, setModalShown] = useState(false);
    const [modalCandidate, setModalCandidate] = useState({});

    useEffect(() => {
        fetchCandidates(props.partyId).then(data => setCandidates(data));
    }, []);


    const handleOpenModal = candidate => {
        setModalCandidate(candidate);
        setModalShown(true);
    };

    const handleHideModal = () => {
        setModalShown(false);
    };

    const handleVote = uuid => {
        saveVote({uuid: uuid}).then(x => {
            console.log("saved: " + uuid);
        });
        setModalShown(false);
    };

    return (
        <div className="candidateList">
            {candidates.map(candidate => {
                return (<Candidate key={candidate.uuid} candidate={candidate} openVoteModalCallback={handleOpenModal}/>)
            })}
            <VoteConfirmationModal
                shown={modalShown}
                candidate={modalCandidate}
                handleHide={handleHideModal}
                handleVote={handleVote}
            />
        </div>
    );
};

CandidateList.propTypes = {
    partyId: PropTypes.number.isRequired
};

export default CandidateList;