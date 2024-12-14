import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { getNewsById } from '../api'; // Импортируем функцию для получения новости по ID

function NewsDetail() {
  const { id } = useParams(); // Получаем ID из URL
  const [news, setNews] = useState(null); // Состояние для хранения данных новости
  const [loading, setLoading] = useState(true); // Состояние для индикации загрузки
  const [error, setError] = useState(null); // Состояние для обработки ошибок

  useEffect(() => {
    // Функция для получения данных новости по ID
    const fetchNews = async () => {
      try {
        const data = await getNewsById(id); // Используем функцию getNewsById
        if (data) {
          setNews(data); // Сохраняем данные в состояние
        } else {
          setError('Новость не найдена'); // Если новость не найдена
        }
      } catch (err) {
        setError(err.message); // Обрабатываем ошибку
      } finally {
        setLoading(false); // Завершаем загрузку
      }
    };

    fetchNews(); // Вызываем функцию при монтировании компонента
  }, [id]); // Зависимость от ID для перезагрузки данных при изменении ID

  if (loading) {
    return <div>Загрузка новости...</div>; // Показываем сообщение во время загрузки
  }

  if (error) {
    return <div>Ошибка: {error}</div>; // Показываем сообщение об ошибке
  }

  if (!news) {
    return <div>Новость не найдена</div>; // Если новость не найдена
  }

  // Функция для форматирования даты
  const formatDate = (dateTime) => {
    const date = new Date(dateTime);
    const formattedDate = date.toLocaleDateString(); // Получаем дату в формате "дд.мм.гггг"
    const formattedTime = date.toLocaleTimeString([], { hour: '2-digit', minute: '2-digit' }); // Получаем время без секунд
    return { date: formattedDate, time: formattedTime };
  };

  const { date, time } = formatDate(news.dateTime); // Форматируем дату и время

  return (
    <div>
      <h1>{news.title}</h1>
      <img
        src={`data:image/jpeg;base64,${news.image}`} // Используем изображение в формате Base64
        alt={news.title}
        style={{ maxWidth: '100%', height: 'auto' }} // Добавляем стили для изображения
      />
      <p>{news.fullDescription}</p>
      <p>Дата: {date} Время: {time}</p>
    </div>
  );
}

export default NewsDetail;