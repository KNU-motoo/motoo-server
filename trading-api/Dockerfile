# --- 1단계: 빌드 환경 ---
FROM gradle:8.5-jdk17 AS build
WORKDIR /app

# 전체 프로젝트 복사 (루트 기준)
COPY . .

# 해당 모듈만 bootJar 빌드
RUN ./gradlew :trading-api:bootJar --no-daemon


# --- 2단계: 실행 환경 ---
FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=build /app/trading-api/build/libs/*.jar app.jar

# 환경변수로 profile 지정
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"]