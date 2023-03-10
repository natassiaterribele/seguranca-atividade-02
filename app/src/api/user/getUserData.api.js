import { axiosInstance } from '../_base/axiosInstance';

const URL_USER_DATA = '/usuarios/detalhar';

export async function getUserData() {
  const response = await axiosInstance.get(URL_USER_DATA);
  return response.data;
}
