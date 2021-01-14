package io.sam.controller;

import io.sam.dto.TestRo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhuweimu
 * @classname XianJiangController
 * @description
 * @date 2020/9/28 14:56
 */
@Slf4j
@RestController
@RequestMapping
public class XianJiangController {

    @PostMapping("uias/oauth/token")
    public String getToken(HttpServletResponse response, HttpServletRequest request){
        return "{\"access_token\":\"f7c55610-6616-45ca-ba6e-7f3c237330de\",\"token_type\":\"bearer\",\"expires_in\":43199,\"scope\":\"read write\"}";
    }

    @PostMapping("uias/unity/user_info")
    public String getUserInfo(HttpServletResponse response, HttpServletRequest request){
        String str = "{\"result\":\"01101101011101010011100001100001010010100100001101100001001100100101100101111001001100000111011101011010011000110110111001001010010011010011010101100101010001000101010001000110010011100100101001110100010101010011011100101111010100110111001101101010010001110100001001010000010101000101100001001011010011010011010101110110010011000110111101100111011101000101100001000001001010110110011001011001011001100100001001000100010001110100101001000110011001100011100001100011010100000101000001111001001100000011010101000111010100000101000001000001010010100100011001111000011100110011011101111001001011110010111101111000010000110011011101101001011101110011001001010010011001100110000100110100011001100101011101001000010000110100001001000101010110100101011001101000010011110110110101100011010001110111010000111001010001100111100101001001011011110011000101011001011110100111100001000111001101010101010101001010001100010111101001101100010010100100111101101100010001010101001001000101001010110100101100110010010011110011001101010100011001110100111000110111001011110101101001100011010000010011100101011000010010000100010001100100010001110111001101010001001100110100010001101100011110000111000101100111010001010100011100110111011000110011010001000111011011010111011101101111011010110110011101111001010011000110111001000001010011000111001001001110010010000011010001000011011110010011100101001110010110010111000001111010011100000110010101101100001100110101011000110010011101000101000101000011010000100111011001010010011110010101001001101010010001010110110001000111011001110111010101111001001100100101001101111000011011010101001101011010001100110111000101100111001100110110100101101010010110100110111001101100011011010011001101000110010011110100101100110111010101000110110101000001011101000100010100101111001110010100110101000110010010010110100001000110011100100100110101010000011011000110011101010111011101000110110000111000010101110101001001010101010110100110010101110101001100000011001001111010011000010111011101010100011101000101001000111000010101100010111100110000001101100110100101101010011101010011000101001110010110000110011000110001011100010011011001100101010011000100000101010101010100100101100101101011011100000100001000110111001101000100111101101011010000100011011000110110011000110100001001010010001101100100010101110111011100010110110001010101011001000101011001110010010010010101101000101011010101000111010001101011011011010101000100111000001010110011011101000010011011000100110100110111011011010100011101100101011001010011001100111001011100110100011001010111011001010011011101101001010000100110101101100110011011000101001101010001010000100011010101001101011001000111001101011001011000010101001001111010011010010101000001000011011110000110100000110101010100110101100001010011011000010011010101101000010100000101100101101101011011010100010001100111010001010011100101000110010101000101000101011010010110100100001000101011011101010110100101001100010011010111011101011001010010000111100000110010001101000110100101110001011010010111001001110000011110000100011001100101001110000010101101101110010100010100110001101001010100010110100100101111010001110110101101100100011110010100110100110110011101110110101001000011010101100101010001110010010110010100010001100010010000100111010101001010010011010110001001110001001101110100101101110110011010010100011001111001011010100111100101001101010010010110011001000001010100100010111101010111011010000101100101010011011110100111000000110001011100110101011000101011010101100111100000110000010110010110010001011000010001100100110101101000011010010011011001000111011110100011011100110110010101000110100001010101011001100100010001011010011101000011100001110001001101110100001101011001011011010111010101101010011001110100101001110011011010000101010001101001001101110100101101000111011001010100001101101110010010010011100001010011001110000110101001000110010110000011100001100001001101110101101001110110010101010100101101000100010010110011011100110010010101100110011100110111010011100101101001111000001101110010101101001000011001110010111100110011010001000011100001101101001100000100010001110111011001110100011101110011011101110111011101001110011010010100111000101111010100100100001101010010010100000011010001101000010100010110010001100001011011100111010101000110010100000110010001000111011001110100011001101011011000010101100001011000011001010101001100111000010101100110011001011010010001000100001100110100011011100100100101110011011010010110011100101011010011010111000001010101011101000011011101001101011011000101011100101011010110000010111100110101001110000011010100110011011101000100110101000011010100010011011101010100001100000110101101111010011010110101001001000011011000100100110001000100001101000110110001010011001100110101001101000100011001100111011101010111010110100100010001111000010101110011001101000010011101100011011101110001010010110101000101000100011100100111101001110111011101000011011101110111010100000110011001001001001100100101100001100111011001110110010101010101011011000110010000110101010011000011100001100011011011100110011001000101011101010011000001010111010000010110110001001011010101110100100101101101010001110110100101100110001011110110111001100001011010110111010001100011001101010110010001101010001110000110111000110111011010000110101101101001011101110111000101010110010010110110101101111001011011110100100101100111001110010100011001000110001110010011001101100011010010100110111101000011001101000101101000110111011110000110101101001010011101100011100001100001011010000111001101100100001100010100011101001111011001010111000101001001010001000011000101001100010101000100001101110011010101000011100000110010001101100111001001111001010011100110010101010010010001110101101001101111011010000101010101001110010011010111001101101010011010000010101101100111010000110100111101100101011110010011000100110000011110000110001100110000010100010100111101001111010110100111000101100110011101110110100000110101010000010011011001111010011000110110101000110000011001000111101001010100010001000100001100111000001101000011001101100111011101100110000101110100011001000100100001100011010000110110101101000100010101000111011001111001011101110111001101001000011001000011010101000001010000010100001001010111010100100111101001010111010001110111000101001101001101100010101101010010011010000100111101110000001100010101000100101111011010100110001001010010011011000011000101110100010011110100100100111000010001100110001101011000011110010100100100101111001100110100101101100011010110010110101101010011001100010110101000110111010001100111011101110010011011110100000101000011001100110011011101100101011001010011100001100010010011110110101101111010011101100101001001001100011110000110001101111000011101000011010001010011010100100011001101100001010011010111000101100010010100000011000001000001010011100110010101101111010100010011110100111101\",\"appCode\":\"65740\"}";
        return str;
    }

    @PostMapping("test")
    public String test(@RequestBody TestRo ro, HttpServletResponse response, HttpServletRequest request){
        System.out.println(ro);
        return "str";
    }
}
