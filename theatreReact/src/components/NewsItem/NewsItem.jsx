import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import styles from './NewsItem.module.css';

function NewsItem({ id, title, description, date, time, imageUrl }) {
  const [isExpanded, setIsExpanded] = useState(false); // Состояние для видимости описания

  return (
    <div className={styles.newsItem}>
      <img src={imageUrl} alt={title} className={styles.image} />
      <div className={styles.content}>
        <h3 className={styles.title}>
          <Link to={`/news/${id}`}>{title}</Link>
        </h3>
        <p className={styles.description}>
          {isExpanded ? description : `${description.slice(0, 100)}...`} {/* Показываем только часть текста */}
          <button
            className={styles.expandButton}
            onClick={() => setIsExpanded(!isExpanded)} // Переключаем состояние
          >
            {isExpanded ? 'Свернуть' : 'Развернуть'}
          </button>
        </p>
        <p className={styles.date}>Дата:{date} Время: {time}</p>
      </div>
    </div>
  );
}

export default NewsItem;