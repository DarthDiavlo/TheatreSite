import React, { useState } from 'react';
import styles from './FeedbackModal.module.css';
import { createFeedback } from '../../api'; // Убедитесь, что путь правильный

function FeedbackModal({ isOpen, onClose }) {
  const [rating, setRating] = useState(0); // Состояние для хранения рейтинга

  if (!isOpen) return null;

  // Функция для обработки выбора рейтинга
  const handleRatingChange = (newRating) => {
    setRating(newRating);
  };

  // Функция для обработки отправки формы
  const handleSubmit = async (event) => {
    event.preventDefault(); // Предотвращаем стандартное поведение формы

    // Собираем данные из формы
    const formData = new FormData(event.target);
    const data = {
      firstname: formData.get('textfeedback'),
      email: formData.get('email'),
      textFeedback: formData.get('firstname'),
      rating: rating, // Добавляем рейтинг
    };

    try {
      // Отправляем данные на сервер с помощью функции createFeedback
      await createFeedback(data);

      // Если запрос успешный, закрываем модальное окно
      onClose();
      alert('Спасибо за ваш отзыв!');
    } catch (error) {
      console.error('Ошибка при отправке отзыва:', error);
      alert('Произошла ошибка при отправке отзыва. Попробуйте позже.');
    }
  };

  return (
    <div className={styles.modalOverlay}>
      <div className={styles.modal}>
        <h2>Обратная связь</h2>
        <form onSubmit={handleSubmit}>
          <div className={styles.formGroup}>
            <label htmlFor="firstname">Ваше имя:</label>
            <input type="text" id="firstname" name="firstname" required />
          </div>
          <div className={styles.formGroup}>
            <label htmlFor="email">Ваш email:</label>
            <input type="email" id="email" name="email" required />
          </div>
          <div className={styles.formGroup}>
            <label htmlFor="textfeedback">Сообщение:</label>
            <textarea id="textfeedback" name="textfeedback" rows="4" required />
          </div>

          {/* Рейтинг с использованием звездочек */}
          <div className={styles.formGroup}>
            <label>Оцените наш сервис:</label>
            <div className={styles.rating}>
              {[1, 2, 3, 4, 5].map((star) => (
                <span
                  key={star}
                  className={`${styles.star} ${star <= rating ? styles.selected : ''}`}
                  onClick={() => handleRatingChange(star)}
                >
                  ★
                </span>
              ))}
            </div>
          </div>

          <button type="submit" className={styles.submitButton}>Отправить</button>
          <button type="button" className={styles.closeButton} onClick={onClose}>
            Закрыть
          </button>
        </form>
      </div>
    </div>
  );
}

export default FeedbackModal;