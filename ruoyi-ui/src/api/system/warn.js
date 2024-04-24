import request from '@/utils/request'

// 查询预警设置列表
export function listWarn(query) {
  return request({
    url: '/system/warn/list',
    method: 'get',
    params: query
  })
}

// 查询预警设置详细
export function getWarn(id) {
  return request({
    url: '/system/warn/' + id,
    method: 'get'
  })
}

// 新增预警设置
export function addWarn(data) {
  return request({
    url: '/system/warn',
    method: 'post',
    data: data
  })
}

// 修改预警设置
export function updateWarn(data) {
  return request({
    url: '/system/warn',
    method: 'put',
    data: data
  })
}

// 删除预警设置
export function delWarn(id) {
  return request({
    url: '/system/warn/' + id,
    method: 'delete'
  })
}
