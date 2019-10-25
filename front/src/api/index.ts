import { Category, Account, History } from '@/types/types';
import { Lang } from '@/types/enums';
import axios from 'axios';

const request = axios.create({
  baseURL: 'http://127.0.0.1:8080',
  timeout: 5000
});

export async function getI18n(lang: Lang): Promise<any> {
  const response: any = await request.get(`/i18n/${lang}`);
  return response.data;
}

export async function getCategories(): Promise<Array<Category>> {
  const response: any = await request.get('/category');
  return response.data.data as Array<Category>;
}

export async function getAccounts(): Promise<Array<Account>> {
  const response: any = await request.get('/account');
  return response.data.data as Array<Account>;
}

export async function getHistories(): Promise<Array<History>> {
  const response: any = await request.get('/history');
  return response.data.data as Array<History>;
}
