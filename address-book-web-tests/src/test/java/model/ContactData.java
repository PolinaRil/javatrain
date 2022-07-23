package model;

public record ContactData(
        String name,
        String patrname,
        String lastname,
        String nickname,
        String title,
        String company,
        String city,
        String home,
        String mobphone,
        String position,
        String fax
) {
}