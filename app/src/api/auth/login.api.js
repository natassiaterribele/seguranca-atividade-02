import { axiosInstance } from '../_base/axiosInstance';

const URL_USER_LOGIN = '/login';

export async function login({ username, password }) {
  const response = await axiosInstance.post(
    URL_USER_LOGIN,
    {},
    {
      auth: {
        username,
        password,
      },
    }
  );
  return response.data;
}
