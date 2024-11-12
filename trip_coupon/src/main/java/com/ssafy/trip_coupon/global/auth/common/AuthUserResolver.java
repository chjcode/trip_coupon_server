package com.ssafy.trip_coupon.global.auth.common;

import com.ssafy.trip_coupon.domain.user.entity.User;
import com.ssafy.trip_coupon.domain.user.entity.UserDAO;
import com.ssafy.trip_coupon.global.error.SystemException;
import com.ssafy.trip_coupon.global.error.code.ClientErrorCode;
import com.ssafy.trip_coupon.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthUserResolver implements HandlerMethodArgumentResolver {

    private final UserDAO userDAO;
    private final JwtUtil jwtUtil;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AuthenticatedUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String token = webRequest.getHeader("Authorization");
        log.info("token:{}", token);
        // 헤더 :  Authorization: Bearer <JWT 토큰>
        if (token == null && !token.startsWith("Bearer ")) {
            throw new SystemException(ClientErrorCode.INVALID_TOKEN);
        }

        // "Bearer " 접두어 제거
        token = token.substring(7);
        log.info("token:{}", token);

        try {
            // 토큰에서 userId 추출
            String userId = jwtUtil.extractUserId(token);
            log.info("userId:{}", userId);

            // userId로 사용자 조회
            User user = userDAO.findUserByEmail(userId);

            if (user == null) {
                throw new SystemException(ClientErrorCode.USER_NOT_FOUND_ERR);
            }

            return userId;
        } catch (Exception e) {
            throw new SystemException(ClientErrorCode.AUTHENTICATION_FAILED);
        }

    }
}
