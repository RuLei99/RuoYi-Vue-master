/*
 * @Author: mitu 2741849187@qq.com
 * @Date: 2024-04-09 16:11:59
 * @LastEditors: mitu 2741849187@qq.com
 * @LastEditTime: 2024-04-09 18:19:52
 * @FilePath: \ruoyi-ui\src\api\system\tryf.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import request from '@/utils/request'


export function alldetail() {
  return request({
    url: '/system/detail/alldetail/' ,
    method: 'get'
  })
}
