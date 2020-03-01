import axios, { AxiosResponse } from 'axios';
import { LocaleMessageObject } from 'vue-i18n';
import { isProd } from '@/constant';

const request = axios.create({
  baseURL: isProd ? '/' : 'http://127.0.0.1:8080',
  timeout: 5000
});

export async function getI18n(lang: Type.Lang): Promise<LocaleMessageObject> {
  const response: AxiosResponse<LocaleMessageObject> = await request.get(`/i18n/${lang}`);

  return response.data;
}

export async function getCategories(): Promise<Type.Category[]> {
  const response: AxiosResponse<Type.Category[]> = await request.get('/api/category');

  return response.data;
}

export async function getAccounts(): Promise<Type.Account[]> {
  const response: AxiosResponse<Type.Account[]> = await request.get('/api/account');

  return response.data;
}

export async function getHistories(): Promise<Type.History[]> {
  const response: AxiosResponse<Type.History[]> = await request.get('/api/history');

  return response.data;
}
