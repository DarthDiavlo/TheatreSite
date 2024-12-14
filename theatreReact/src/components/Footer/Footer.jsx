import React, { useState } from 'react';
import styles from './Footer.module.css';
import FeedbackModal from './FeedbackModal/FeedbackModal';

function Footer() {
  const [isModalOpen, setIsModalOpen] = useState(false);

  const openModal = () => setIsModalOpen(true);
  const closeModal = () => setIsModalOpen(false);

  return (
    <footer className={styles.footer}>
      <div className={styles.footerContent}>
        <p>&copy; 2024 ОАО театр</p>
        <button className={styles.feedbackButton} onClick={openModal}>
          Обратная связь
        </button>
      </div>
      <FeedbackModal isOpen={isModalOpen} onClose={closeModal} />
    </footer>
  );
}

export default Footer;