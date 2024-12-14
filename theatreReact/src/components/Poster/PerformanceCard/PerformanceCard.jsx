import React from 'react';
import styles from './PerformanceCard.module.css';

function PerformanceCard({ title, description, date, time, imageUrl }) {
  return (
    <div className={styles.card}>
      <img src={imageUrl} alt={title} className={styles.image} />
      <div className={styles.content}>
        <h3 className={styles.title}>{title}</h3>
        <p className={styles.description}>{description}</p>
        <p className={styles.date}>Дата: {date}</p>
        <p className={styles.time}>Время: {time}</p>
      </div>
    </div>
  );
}

export default PerformanceCard;