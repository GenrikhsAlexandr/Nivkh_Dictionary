package com.aleksandrgenrikhs.nivkhdictionary.data

import com.aleksandrgenrikhs.nivkhdictionary.domain.Word
import com.ncbs.dictionary.domain.LocaleData
import java.util.Locale

class MapperWord {
    fun mapToWord(wordDto: WordDto): Word? {
        return Word(
            id = wordDto.id ?: return null,
            locales = buildMap {
                put(
                    "nv", LocaleData(
                        locale = Locale("nv"),
                        value = wordDto.nv ?: return null
                    )
                )
                wordDto.ru?.let {
                    put(
                        "ru", LocaleData(
                            locale = Locale("ru"),
                            value = it
                        )
                    )
                }
                wordDto.en?.let {
                    put(
                        "en", LocaleData(
                            locale = Locale.ENGLISH,
                            value = it
                        )
                    )
                }
            }
        )
    }
}