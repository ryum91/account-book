import { Response, Category, Account, History } from '@/types/types';
import { Lang } from '@/types/types';
import axios, { AxiosResponse } from 'axios';
import { LocaleMessageObject } from 'vue-i18n';

const request = axios.create({
  baseURL: 'http://127.0.0.1:8080',
  timeout: 5000
});

export async function getI18n(lang: Lang): Promise<LocaleMessageObject> {
  const response: AxiosResponse<LocaleMessageObject> = await request.get(`/i18n/${lang}`);
  return response.data;
}

export async function getCategories(): Promise<Category[]> {
  const response: AxiosResponse<Response<Category[]>> = await request.get('/api/category');
  return response.data.data;
}

export async function getAccounts(): Promise<Account[]> {
  const response: AxiosResponse<Response<Account[]>> = await request.get('/api/account');
  return response.data.data;
}

export async function getHistories(): Promise<History[]> {
  const response: AxiosResponse<Response<History[]>> = await request.get('/api/history');
  return response.data.data;
}
