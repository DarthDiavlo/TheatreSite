import React from 'react';
import styles from './MainContent.module.css';
import NewsList from '../NewsList/NewsList';

function MainContent() {
  return (
    <main className={styles.mainContent}>
      <NewsList />
    </main>
  );
}

export default MainContent;