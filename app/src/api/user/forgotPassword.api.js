import { axiosInstance } from '../_base/axiosInstance';

const URL_FORGOT_PASSWORD = '/usuarios/esqueci-senha';

export async function forgotPassword({ email }) {
  const response = await axiosInstance.post(URL_FORGOT_PASSWORD, {
    email: email,
  });
  return response.data;
}
