import axios from 'axios';

function host(url: string) {
  return `http://127.0.0.1:8080${url}`;
}

export function getCategories() {
  return axios.get(host('/category')).then((e) => e.data.data);
}
