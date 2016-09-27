/**
 * Source: https://github.com/ebayopensource/turmeric-runtime/blob/master/soa-server/src/main/java/org/ebayopensource/turmeric/runtime/spf/impl/transport/http/HTTPServerUtils.java
 */
private void applyQueryMap(UrlMappingsDesc mappingDesc) throws ServiceException {
    Map<String, String> queryMap = mappingDesc.getQueryMap();
    Map<String, String> upperCaseQueryMap = mappingDesc.getUpperCaseQueryMap();

    for (int i = 0; i < m_params.size(); i++) {
        ParamData param = m_params.get(i);
        String paramName = param.getDecodedName();
        String headerName = queryMap.get(paramName);
        if (headerName == null) {
           headerName = upperCaseQueryMap.get(paramName.toUpperCase());
        }
        if (headerName != null) {
           checkIfSecurityCredential(headerName);
           String paramValue = param.getDecodedValue();
           addTransportHeader(headerName, paramValue);
           param.setConsumed();
        }
    }
}
