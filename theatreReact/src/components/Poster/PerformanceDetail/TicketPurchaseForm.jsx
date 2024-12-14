import React from 'react';
import styles from './TicketPurchaseForm.module.css'; // Подключите стили, если они есть

function TicketPurchaseForm({ performance, onSubmit, onCancel }) {
  // Обработчик отправки формы
  const handleFormSubmit = (e) => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const data = Object.fromEntries(formData.entries());

    // Добавляем дополнительные данные (например, ID спектакля и цену)
    const ticketData = {
      perfomanceId: performance.id, // ID спектакля
      email: data.email,
      date: performance.date + ' '+ performance.time, // Дата и время спектакля
      row: parseInt(data.row), // Ряд
      column: parseInt(data.seat), // Место
      price: performance.minPrice, // Цена (можно выбрать minPrice или maxPrice)
    };

    onSubmit(ticketData); // Передаем данные в родительский компонент
  };

  return (
    <div className={styles.formContainer}>
      <form onSubmit={handleFormSubmit} className={styles.ticketForm}>
        <h2>Форма покупки билета</h2>
        <div>
          <label htmlFor="date">Дата и время спектакля:</label>
          <input
            type="text"
            id="date"
            name="date"
            value={`${performance.date} ${performance.time}`}
            readOnly
          />
        </div>
        <div>
          <label htmlFor="row">Ряд:</label>
          <input type="number" id="row" name="row" required />
        </div>
        <div>
          <label htmlFor="seat">Место:</label>
          <input type="number" id="seat" name="seat" required />
        </div>
        <div>
          <label htmlFor="email">Email пользователя:</label>
          <input type="email" id="email" name="email" required />
        </div>
        <div>
          <label htmlFor="price">Цена билета:</label>
          <input
            type="text"
            id="price"
            name="price"
            value={`15000`}
            readOnly
          />
        </div>
        <button type="submit">Заказать билет</button>
        <button type="button" onClick={onCancel}>
          Отмена
        </button>
      </form>
    </div>
  );
}

export default TicketPurchaseForm;