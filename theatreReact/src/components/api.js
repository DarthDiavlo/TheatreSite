import axios from 'axios';

// Функция для получения всех новостей
export const getAllNews = async () => {
  try {
    const response = await axios.get('http://localhost:8093/v1/allnews');
    return response.data; // Возвращает массив новостей с изображениями
  } catch (error) {
    console.error('Error fetching all news:', error);
    throw new Error('Failed to fetch all news');
  }
};

// Функция для получения новости по ID
export const getNewsById = async (id) => {
  try {
    const response = await axios.get(`http://localhost:8093/v1/news/${id}`);
    return response.data; // Возвращает одну новость с изображением
  } catch (error) {
    console.error(`Error fetching news with ID ${id}:`, error);
    throw new Error(`Failed to fetch news with ID ${id}`);
  }
};

export const getAllPerfomances = async () => {
  try {
    const response = await axios.get('http://localhost:8093/v1/perfomances/all');
    console.log(response);
    return response.data; // Возвращает массив представлений
  } catch (error) {
    console.error('Error fetching all performances:', error);
    throw new Error('Failed to fetch all performances');
  }
};

export const getPerfomanceById = async (id) => {
  try {
    const response = await axios.get(`http://localhost:8093/v1/perfomances/${id}`);
    return response.data; // Возвращает представление
  } catch (error) {
    console.error('Error fetching performance by ID:', error);
    throw new Error('Failed to fetch performance by ID');
  }
};

export const createTicket = async (ticketData) => {
  try {
    const response = await axios.post('http://localhost:8093/v1/tickets', ticketData);
    return response.data;
  } catch (error) {
    console.error('Ошибка при создании билета:', error);
    throw new Error('Не удалось создать билет');
  }
};

export const createFeedback = async (feedbackData) => {
  try {
    const response = await axios.post('http://localhost:8093/v1/feedback', feedbackData);
    return response.data; // Возвращаем данные ответа сервера
  } catch (error) {
    console.error('Ошибка при отправке отзыва:', error);
    throw new Error('Не удалось отправить отзыв');
  }
};