import { Category } from '@/types';
import axios from 'axios';

const request = axios.create({
  baseURL: 'http://127.0.0.1:8080',
  timeout: 5000
});

export async function getCategories(): Promise<Array<Category>> {
  const response: any = await request.get('/category');
  return response.data.data as Array<Category>;
}
