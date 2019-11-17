import request from '@/utils/http'


export function getRegisterVerifyCode(data) {
    return request({
        url: `api/admin/auth/code/email/register`,
        method: 'get',
        data
    })
}
