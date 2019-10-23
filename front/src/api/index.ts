import { Category } from '@/types';
import axios from 'axios';

function host(url: string) {
  return `http://127.0.0.1:8080${url}`;
}

export async function getCategories(): Promise<Category[]> {
  const response = await axios.get(host('/category'));
  return response.data.data;
}
