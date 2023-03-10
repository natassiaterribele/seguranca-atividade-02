import { axiosInstance } from '../_base/axiosInstance';

const URL_USER_LOGOUT = '/logout';

export async function logout() {
  await axiosInstance.post(URL_USER_LOGOUT, {});
}
