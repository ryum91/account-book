import { Response, Category, Account, History } from '@/types/types';
import { Lang } from '@/types/types';
import axios, { AxiosResponse } from 'axios';
import { LocaleMessageObject } from 'vue-i18n';

const request = axios.create({
  baseURL: 'http://127.0.0.1:8080',
  timeout: 5000
});

export async function getI18n(lang: Lang) {
  const response: AxiosResponse<LocaleMessageObject> = await request.get(`/i18n/${lang}`);
  return response.data;
}

export async function getCategories() {
  const response: AxiosResponse<Response<Category[]>> = await request.get('/category');
  return response.data.data;
}

export async function getAccounts() {
  const response: AxiosResponse<Response<Account[]>> = await request.get('/account');
  return response.data.data;
}

export async function getHistories() {
  const response: AxiosResponse<Response<History[]>> = await request.get('/history');
  return response.data.data;
}
